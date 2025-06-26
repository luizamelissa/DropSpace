import React, { useEffect, useState } from 'react';
import api from '../api';

function CategoryList() {
  const [categorias, setCategorias] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem('token');
    api.get('/categorias', {
      headers: { Authorization: `Bearer ${token}` }
    }).then(res => setCategorias(res.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div>
      <h1>Categorias</h1>
      <ul>
        {categorias.map(cat => (
          <li key={cat.id}>{cat.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default CategoryList;
