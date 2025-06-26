import React, { useEffect, useState } from 'react';
import api from '../api';

function Dashboard() {
  const [stores, setStores] = useState([]);
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem('token');
    api.get('/store', { headers: { Authorization: `Bearer ${token}` } })
      .then(res => setStores(res.data))
      .catch(err => console.log(err));

    api.get('/product', { headers: { Authorization: `Bearer ${token}` } })
      .then(res => setProducts(res.data))
      .catch(err => console.log(err));
  }, []);

  return (
    <div>
      <h1>Dashboard</h1>
      <h2>Lojas</h2>
      <ul>
        {stores.map(store => <li key={store.id}>{store.name}</li>)}
      </ul>
      <h2>Produtos</h2>
      <ul>
        {products.map(prod => <li key={prod.id}>{prod.name}</li>)}
      </ul>
    </div>
  );
}

export default Dashboard;
