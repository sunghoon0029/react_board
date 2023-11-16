import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Board from "../components/Board";

const BoardDetail = () => {

    const { id } = useParams();
    const [loading, setLoading] = useState(true);
    const [board, setBoard] = useState({});

    const getBoard = async () => {
        const res = await axios.get(`http://localhost:8080/board/${id}`);
        setBoard(res.data);
        setLoading(false);
    };

    useEffect(() => {
        getBoard();
    }, []);

    return (
        <div>
            {loading ? (
                <h2>loading...</h2>
            ) : (
                <Board
                    id={board.id}
                    writer={board.writer}
                    title={board.title}
                    content={board.contents}
                    hits={board.hits}
                    createdTime={board.createdTime}
                />
            )}
        </div>
    );
};

export default BoardDetail;