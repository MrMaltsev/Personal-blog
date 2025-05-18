import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function ArticleDetail() {
  const { id } = useParams();
  const [article, setArticle] = useState(null);

  useEffect(() => {
    fetch(`http://localhost:8080/api/articles/${id}`)
      .then((res) => res.json())
      .then((data) => {
        console.log("Полученная дата", data.createDate) 
        setArticle(data);
      })
  }, [id]);

  if (!article) return <p>Loading...</p>;

  function formatDate(dateString) {
    if (!dateString) return ' '; 
    const clean = dateString.replace(' ', 'T');
    return new Date(clean).toLocaleString();
  }

  return (
    <div>
      <h1>{article.articleName}</h1>
      <p>{article.articleText}</p>
      <p>
        <em>Created: {formatDate(article.createDate)}</em>
      </p>
    </div>
  );
}

export default ArticleDetail;
