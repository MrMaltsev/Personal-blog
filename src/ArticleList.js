
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import './ArticleList.css';

function ArticleList() {
  const [articles, setArticles] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/articles')
      .then(response => response.json())
      .then(data => setArticles(data));
  }, []);

  return (
    <div className="container">
      <h1 className="title">My personal blog</h1>
      <Link to="/new" className="add-post-button">➕ Добавить пост</Link>
      <ul className="article-list">
        {articles.map(article => (
          <li key={article.id} className="article-item">
            <Link to={`/articles/${article.id}`} className="article-link">
              {article.articleName}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ArticleList;
