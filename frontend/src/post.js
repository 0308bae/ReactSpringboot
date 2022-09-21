import React from "react";

function handleSaveSubmit(event) {
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
    fetch(`/board/posts`, model)
        .then((response) => response.json());
}

function Write() {

    return (
        <div className='Write'>
            <form onSubmit={handleSaveSubmit} method="post" id="formTable">
                <div>
                    <input type='text' id='title' name='title' placeholder='제목'/>
                </div>
                <div>
                    <input id='contents' name='contents' placeholder='설문내용'/>
                </div>
                <div id="submit_btn">
                    <button type="submit">저장</button>
                    <input type="reset"/>
                </div>
            </form>
        </div>
    );
}

export default Write;