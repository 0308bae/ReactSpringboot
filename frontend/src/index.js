import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';




class List extends React.Component{
    constructor(props) {
        let post;
        super(props);
        fetch("/board/posts/1")
            .then(data => data.json())
            .then(res => post = res);
    }

    render() {
        return (
            <div className='List'>
                {
                    this.state.post.map(
                        post =>
                            <tr key={post.boardId}>
                                <td> {post.title} </td>
                                <td> {post.contents} </td>
                            </tr>
                    )
                }
                </div>
        )
    }
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
    <List/>
);