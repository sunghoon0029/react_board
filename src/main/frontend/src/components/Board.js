import React from "react";

const Board = ({ id, writer, title, content }) => {

    return (
        <div>
            <h2>{title}</h2>
            <h5>{writer}</h5>
            <hr />
            <p>{content}</p>
        </div>
    );
};

export default Board;