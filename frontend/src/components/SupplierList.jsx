import React, { useEffect, useState } from 'react';
import api from '../api';

function SupplierList() {
  const [suppliers, setSuppliers] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem('token');
    api.get('/fornecedores', {
      headers: { Authorization: `Bearer ${token}` }
    }).then(res => setSuppliers(res.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div>
      <h1>Fornecedores</h1>
      <ul>
        {suppliers.map(s => (
          <li key={s.id}>{s.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default SupplierList;
