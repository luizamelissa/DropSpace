import React, { useState } from 'react';
import api from '../api';
import { useNavigate } from 'react-router-dom';

function CadastroProduto() {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [price, setPrice] = useState('');
  const [stock, setStock] = useState('');
  const [categoryId, setCategoryId] = useState('');
  const [storeId, setStoreId] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async () => {
    try {
      const token = localStorage.getItem('token');
      await api.post('/produtos', {
        name, description, price, stock,
        category: { id: categoryId },
        store: { id: storeId }
      }, {
        headers: { Authorization: `Bearer ${token}` }
      });
      alert('Produto cadastrado!');
      navigate('/produtos');
    } catch (err) {
      console.error(err);
      alert('Erro ao cadastrar');
    }
  };

  return (
    <div>
      <h1>Cadastro de Produto</h1>
      <input placeholder="Nome" onChange={e => setName(e.target.value)} />
      <input placeholder="Descrição" onChange={e => setDescription(e.target.value)} />
      <input type="number" placeholder="Preço" onChange={e => setPrice(e.target.value)} />
      <input type="number" placeholder="Estoque" onChange={e => setStock(e.target.value)} />
      <input placeholder="ID da Categoria" onChange={e => setCategoryId(e.target.value)} />
      <input placeholder="ID da Loja" onChange={e => setStoreId(e.target.value)} />
      <button onClick={handleSubmit}>Salvar</button>
    </div>
  );
}

export default CadastroProduto;
