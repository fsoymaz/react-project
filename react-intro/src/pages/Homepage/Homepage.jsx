import React, { useEffect } from 'react'
import { Link, json } from 'react-router-dom'

export default function Homepage() {
	const myAsyncFunction = () => {
		return new Promise((resolve, reject) => {
			// resolve ve reject fonksiyonları şu işe yarar :
			// resolve fonksiyonu ile promise'in sonucu başarılı bir şekilde döndürülür. 
			//reject fonksiyonu ile promise'in sonucu başarısız bir şekilde döndürülür.
				resolve('HTTP VERİSİ')
		})
	}

	useEffect(() => {
		makeAsyncCall();
		makeHttpCall();

	}, []);

	const makeAsyncCall = async () => {
		//myAsyncFunction().then((response) => { // async işlem başarı ise (resolve edildi ise)
		//    console.log("işlem başarılı cevap: ", response);
		//})
		//.catch((error) => { // async işlem başarısız ise (reject edildi ise)
		//    console.log("işlem başarısız cevap: ", error);
		//})
		//.finally(() => { // finally fonksiyonu ile promise'in sonucu ne olursa olsun çalıştırılacak fonksiyon belirlenir.
		//    console.log("işlem bitti");
		//}); // en sonunda çalışacak fonksiyon
		// es2017 ile gelen async ve await kullanımı
		try {
			let response = await myAsyncFunction();
			console.log("işlem başarılı cevap: ", response);
		}
		catch (e) {
			console.log("işlem başarısız cevap: ", e);
		}
	}

	const makeHttpCall = async () => {
		//let response = await fetch('https://jsonplaceholder.typicode.com/todos/1')
		//.then(response => response.json())
		//.then(json => console.log(json))
		//.catch(error => console.log(error));
			// zincirleme promise kullanımı
			let response = await fetch('https://dummyjson.com/products');
			let json = await response.json();
			console.log(json);
	}
	return (
		<div>
			<button className='btn btn-primary'>Homepage</button>
			<br />
			<Link to={"/about"}>About a git</Link>
		</div>
	)
}