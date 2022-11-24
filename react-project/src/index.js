import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';


/* const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
); */

// 기존 코드는 다음과 같이 ReactDOM의 createRoot 함수를 통해 root 객체를 만들어주고, 해당 객체를 render하는 방식으로 되어 있었습니다. 하지만 이건 리액트 18.0 버전에서 사용하는 방식이고, 하위 버전에서는 동작하지 않습니다.
// 따라서 다음과 같이 코드를 수정해주어야 합니다. ReactDOM이 직접 render하는 구조이며 document.getElementById('root')는 render의 파라미터로 전달되었습니다.

ReactDOM.render(
/*   <React.StrictMode>
    <App />
  </React.StrictMode>, */
  <App />,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
