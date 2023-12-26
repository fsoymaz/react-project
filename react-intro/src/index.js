import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';

//import Default, {Not default} from './App';
//import variable3 ,{App, variable, variable2} from 'file name';
// program buradan başlıyor
import App from './App';
import 'bootstrap/dist/css/bootstrap.min.css';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));

// Self closing tag => <img />
// normal tag => <img></img>
// node modules silebilirim npm i ile yeniden yükleyebilirim
root.render(<App />);

// Eğer uygulamanızdaki performansı ölçmeye başlamak isterseniz, bir fonksiyon geçirin
// sonuçları loglamak için (örneğin: reportWebVitals(console.log))
// veya bir analitik uç noktasına gönderin. Daha fazla bilgi edinin:
// https://bit.ly/CRA-vitals
reportWebVitals();
