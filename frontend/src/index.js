import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';




class List extends React.Component{
    constructor(props) {
        super(props);
        let data;
        fetch("/board/posts/list")
            .then(res => res.json())
            .then(res => console.log(res))
            .then(res => data = res);
        this.state = {
            postList: data,
        }
    }

    render() {
        const list = []
        for(let i = 0; i < this.state.postList.length; i++){
            list.push(
                <div className="post" key={i}>
                    {this.state.postList.get(i)}
                </div>
            )
        }
        return (
            <div className='List'>
                {list}
            </div>
        )
    }
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
    <List/>
);