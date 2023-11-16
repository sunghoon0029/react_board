import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const BoardPageList = () => {

    const navigate = useNavigate();

    const [boardPageList, setBoardPageList] = useState([]);

    const getBoardPageList = async () => {

        const res = await axios.get('http://localhost:8080/board/paging');
        setBoardPageList(res.data);
    };

    const moveToWrite = () => {
        navigate('/write');
    }

    useEffect(() => {
        getBoardPageList();
    }, []);

    return (
        <div>
            <ul>
                {boardPageList.map((board) => (
                    <li key={board.id}>
                        <a>{board.id}</a>
                        &nbsp;&nbsp;|&nbsp;&nbsp;
                        <Link to={`/board/${board.id}`}>{board.title}</Link>
                        &nbsp;&nbsp;|&nbsp;&nbsp;
                        <a>{board.createdTime}</a>
                        &nbsp;&nbsp;|&nbsp;&nbsp;
                        <a>{board.hits}</a>
                    </li>
                ))}
            </ul>
            <div>
                <button onClick={moveToWrite}>게시글 작성</button>
            </div>
        </div>
    );
};

export default BoardPageList;