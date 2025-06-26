import React, { useEffect, useState } from 'react';
import api from '../Service/api';

function ListaProdutos() {
  const [produtos, setProdutos] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem('token');
    api.get('/produtos', {
      headers: { Authorization: `Bearer ${token}` }
    })
    .then(res => setProdutos(res.data))
    .catch(err => console.error(err));
  }, []);

  return (
    <div>
      <h1>Lista de Produtos</h1>
      <ul>
        {produtos.map(p => (
          <li key={p.id}>
            <strong>{p.name}</strong> — {p.description} — R${p.price}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListaProdutos;
