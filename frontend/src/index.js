import React, {useState} from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';

function handleSubmit(event) {
    event.preventDefault();
    const data = new FormData(event.target);
    const value = Object.fromEntries(data.entries());
    let model = {
        method: 'POST',
        body: JSON.stringify(value),
        headers: {
            'Content-Type': 'application/json'
        }
    };
    fetch(`/hello/posts`, model)
        .then((response) => response.json())
        .then((value) => {
            console.log(value);
        })
        .catch(
            (e) => {
                console.log(e);
            });
}

function Hello(){
    const [data, setData] = useState("");
    const [name, setName] = useState("");
    function eventHandler(e) {
        setName(e.target.value)
        fetch(`/hello?name=${e.target.value}`)
            .then(res => res.json())
            .then(res => setData(res));
    }


    return (
        <div>
            <input onChange={eventHandler} type="text" value={name}/>
            <p>{data.name}</p>
        </div>
    );
}


function Write() {

    return (
        <div className='Write'>
            <form onSubmit={handleSubmit} action="/hello/posts" method="post" id="formTable">
                <div>
                    <input type='text' id='title' name='title' placeholder='제목'/>
                </div>
                <div>
                    <input id='content' name='contents' placeholder='설문내용'></input>
                </div>
                <div id="submit_btn">
                    <button type="submit">저장</button>&nbsp;&nbsp;
                    <button>취소</button>
                </div>
            </form>&nbsp;&nbsp;
            <Hello/>
        </div>
    );
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
    <React.StrictMode>
        <Write/>
    </React.StrictMode>
);