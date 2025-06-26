import React, { useEffect, useState } from 'react';
import api from '../api';

function StoreList() {
  const [stores, setStores] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem('token');
    api.get('/lojas', {
      headers: { Authorization: `Bearer ${token}` }
    }).then(res => setStores(res.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div>
      <h1>Lojas</h1>
      <ul>
        {stores.map(store => (
          <li key={store.id}>{store.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default StoreList;
