import React, { useState } from 'react';

function TodoList() {
  const [todos, setTodos] = useState(['Todo 1', 'Todo 2']); // Initial todo items
  const [input, setInput] = useState('');

  const addTodo = () => {
	if (input.trim() !== '') {
	  if (!todos.includes(input)) {
		setTodos([...todos, input]); // Add the new todo item to the end of the list
		console.log(`Eklenen todo: ${input}`); // Log the added todo item
	  } else {
		window.alert('Bu öğe zaten listende var!');
	  }
	  setInput('');
	}
  };

  const deleteTodo = (index) => {
    setTodos(todos.filter((_, todoIndex) => todoIndex !== index));  // _ is a placeholder for the todo item
  };

  return (
    <div className="center">
      <input
        className="todo-input"
        value={input}
        onChange={e => setInput(e.target.value)}
        onKeyDown={e => e.key === 'Enter' && addTodo()}
      />
      <button className="add-btn" onClick={() => {addTodo();}}>Ekle</button>
      <ul className="todo-list">
        {todos.map((todo, index) => ( // We need to add a key prop to each item in the list
          <li key={index} className="todo-item">
            {todo}
            <button className="delete-btn" onClick={() => deleteTodo(index)}>Sil</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TodoList;