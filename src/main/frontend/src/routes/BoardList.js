import axios from "axios";
import React, { useEffect, useState } from "react";

const BoardList = () => {

    const [boardList, setBoardList] = useState([]);

    const getBoardList = async () => {
        const res = (await axios.get('//localhost:8080/board/')).data
        console.log(res.data);
    }

    useEffect(() => {
        getBoardList();
    }, []);

    return (
        <div>
            <h2>게시판 목록</h2>
        </div>
    );
};

export default BoardList;