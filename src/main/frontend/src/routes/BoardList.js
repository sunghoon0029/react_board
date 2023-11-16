import { useState, useEffect } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

const BoardList = () => {

    const navigate = useNavigate();

    const [boardList, setBoardList] = useState([]);

    const getBoardList = async () => {
        const res = await axios.get('http://localhost:8080/board/');
        setBoardList(res.data);
    };

    const moveToWrite = () => {
        navigate('/write');
    };

    useEffect(() => {
        getBoardList();
    }, []);

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
        </div>
    );
};

export default BoardList;