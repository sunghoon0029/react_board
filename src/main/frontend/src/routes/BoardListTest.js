import { useState, useEffect } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

const BoardListTest = () => {

    const navigate = useNavigate();
    const [boardList, setBoardList] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [totalPages, setTotalPages] = useState(1);

    const getBoardList = async (page) => {
        const res = await axios.get(`http://localhost:8080/board/?page=${page}`);
        
        console.log(res.data);
        setBoardList(res.data);

        const pageInfo = res.data.pagination;
        setCurrentPage(pageInfo.currentPage);
        setTotalPages(pageInfo.totalPages);
    };

    const moveToWrite = () => {
        navigate('/write');
    };

    const handlePageChange = (page) => {
        getBoardList(page);
    };

    useEffect(() => {
        getBoardList(currentPage);
    }, [currentPage]);

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
                <button onClick={moveToWrite}>게시글 작성</button>
            </div>
            <div>
                <p>현재 페이지: {currentPage}</p>
                <p>전체 페이지: {totalPages}</p>
                <button disabled={currentPage === 1} onClick={() => handlePageChange(currentPage - 1)}>
                    이전
                </button>
                <button disabled={currentPage === totalPages} onClick={() => handlePageChange(currentPage + 1)}>
                    다음
                </button>
            </div>
        </div>
    );
};

export default BoardListTest;