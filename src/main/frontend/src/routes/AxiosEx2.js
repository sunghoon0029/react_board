import { useState, useEffect } from "react";
import axios from "axios";

const AxiosEx2 = () => {

    const [posts, setPosts] = useState([]);

    const getPosts = async () => {
        const res = await axios.get('http://localhost:8080/board/');
        setPosts(res.data);
    }

    useEffect(() => {
        getPosts();
    }, []);

    return (
        <ul>
            {posts.map(post => (
                <li key={post.id}>{post.title}</li>
            ))}
        </ul>
    );
};

export default AxiosEx2;