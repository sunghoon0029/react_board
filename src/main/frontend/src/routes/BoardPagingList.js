import { useState, useEffect } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

const BoardPagingList = () => {

    const navigate = useNavigate();

    const [boardList, setBoardList] = useState([]);
    const [pageList, setPageList] = useState([]);

    const [curPage, setCurPage] = useState(0);
    const [prevBlock, setPrevBlock] = useState(0);
    const [nextBlock, setNextBlock] = useState(0);
    const [lastPage, setLastPage] = useState(0);

    const [search, setSearch] = useState({
        page: 1,
        sk: '',
        sv: '',
    });

    const getBoardList = async () => {

        if (search.page === curPage) return;

        const queryString = Object.entries(search)
            .map((e) => e.join('='))
            .join('&');

        const res = await axios.get('http://localhost:8080/board/?' + queryString);

        setBoardList(res.data);

        const pngn = res.pagination;

        const { endPage, nextBlock, prevBlock, startPage, totalPageCnt } = pngn || {};

        setCurPage(search.page);
        setPrevBlock(prevBlock);
        setNextBlock(nextBlock);
        setLastPage(totalPageCnt);

        const tmpPages = [];
        for (let i = startPage; i <= endPage; i++) {
            tmpPages.push(i);
        }

        setPageList(tmpPages);
    };

    const moveToWrite = () => {
        navigate('/write');
    };

    const onClick = (event) => {
        let value = event.target.value;
        setSearch({
            ...search,
            page: value,
        });

        getBoardList();
    };

    const onChange = (event) => {
        const { value, name } = event.target;
        setSearch({
            ...search,
            [name]: value,
        });
    };

    const onSearch = () => {
        if (search.sk !== '' && search.sv !== '') {
            setSearch({
                ...search,
                page: 1,
            });
            setCurPage(0);
            getBoardList();
        }
    };

    useEffect(() => {
        getBoardList();
    }, [search]);

    return (
        <div>
            <ul>
                {boardList.map((board) => (
                    <li key={board.id}>
                        <Link to={`/board/${board.id}`}>{board.title}</Link>
                    </li>
                ))}
            </ul>
            <div>
                <button onClick={onClick} value={1}>
                    &lt;&lt;
                </button>
                <button onClick={onClick} value={prevBlock}>
                    &lt;
                </button>
                {pageList.map((page, index) => (
                    <button key={index} onClick={onClick} value={page}>
                        {page}
                    </button>
                ))}
                <button onClick={onClick} value={nextBlock}>
                    &gt;
                </button>
                <button onClick={onClick} value={lastPage}>
                    &gt;&gt;
                </button>
            </div>
            <br />
            <div>
                <select name="sk" onChange={onChange}>
                    <option value="">-선택-</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                <input type="text" name="sv" id="" onChange={onChange} />
                <button onClick={onSearch}>검색</button>
            </div>
            <br />
            <div>
                <button onClick={moveToWrite}>게시글 작성</button>
            </div>
        </div>
    );
};

export default BoardPagingList;