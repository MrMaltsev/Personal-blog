import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ArticleList from "./ArticleList";
import ArticleDetail from "./ArticleDetail";
import NewArticle from "./NewArticle";

function App() {
  console.log("App rendered");

  return (
    <Router>
      <Routes>
        <Route path="/" element={<ArticleList />} />
        <Route path="/articles/:id" element={<ArticleDetail />} />
        <Route path="/new" element={<NewArticle />} />
      </Routes>
    </Router>
  );
}

export default App;
