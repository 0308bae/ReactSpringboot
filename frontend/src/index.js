import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';




class List extends React.Component{
    constructor(props) {
        super(props);
        fetch("/board/posts/1")
            .then(res => res.text())
            .then(data => {
                console.log(data);
                data = data.json();
            })
    }

    render() {
        return (
            <div className='List'>
                {
                    this.state.data.map(
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