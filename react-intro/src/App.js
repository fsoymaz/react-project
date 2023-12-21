import './App.css';
import React, { useState } from 'react';

function App() {
  const [text, setText] = useState('');
  const [todos, setTodos] = useState(['Todo 1', 'Todo 2']); // Initial todo items

  const handleChange = (event) => {
    setText(event.target.value);
  };

  const handleAdd = () => {
    if (text.trim() !== '') {
      setTodos([...todos, text]);
      setText('');
    }
  };

  const handleDelete = (index) => {
    const newTodos = [...todos];
    newTodos.splice(index, 1);
    setTodos(newTodos);
  };

  const handleKeyDown = (event) => {
    if (event.key === 'Enter') {
      handleAdd();
    }
  };

  return (
    <div className="center">
      <input
        onChange={handleChange}
        onKeyDown={handleKeyDown}
        value={text}
        type="text"
      />
      <button type='button' onClick={handleAdd}>Ekle</button>
      <ul>
        {todos.map((todo, index) => (
          <li key={index}>
            {todo}
            <button type='button' onClick={handleDelete.bind(undefined, index)}>Sil</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
