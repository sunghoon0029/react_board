import { useState, useEffect } from "react";
import axios from "axios";

const AxiosEx1 = () => {

    const [posts, setPosts] = useState([]);

    useEffect(() => {
        axios({
            method: 'GET',
            url: 'http://localhost:8080/board/'
        }).then(response => setPosts(response.data))
    });

    return (
        <ul>
            {posts.map(post => (
                <li key={post.id}>{post.title}</li>
            ))}
        </ul>
    );
};

export default AxiosEx1;