import { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const BoardList = () => {

    const [boardList, setBoardList] = useState([]);

    const getBoardList = async () => {
        const res = await axios.get('http://localhost:8080/board/');
        setBoardList(res.data);

        const page = res.pagination;
        console.log(page);
    };

    useEffect(() => {
        getBoardList();
    }, []);

    return (
        <ul>
            {boardList.map(board => (
                <li key={board.id}>
                    <Link to={`/board/${board.id}`}>{board.title}</Link>
                </li>
            ))}
        </ul>
    );
};

export default BoardList;