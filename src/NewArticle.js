// src/NewArticle.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './NewArticle.css';

function NewArticle() {
  const [articleName, setArticleName] = useState('');
  const [articleText, setArticleText] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    const newArticle = { articleName, articleText };

    const response = await fetch('http://localhost:8080/api/articles', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newArticle),
    });

    if (response.ok) {
      navigate('/');
    } else {
      alert('Ошибка при добавлении статьи');
    }
  };

  return (
    <div className="new-article-container">
      <h2>Добавить статью</h2>
      <form onSubmit={handleSubmit} className="new-article-form">
        <label>
          Заголовок:
          <input
            type="text"
            value={articleName}
            onChange={(e) => setArticleName(e.target.value)}
            required
          />
        </label>
        <label>
          Содержание:
          <textarea
            value={articleText}
            onChange={(e) => setArticleText(e.target.value)}
            rows="6"
            required
          />
        </label>
        <button type="submit">Сохранить</button>
      </form>
    </div>
  );
}

export default NewArticle;
