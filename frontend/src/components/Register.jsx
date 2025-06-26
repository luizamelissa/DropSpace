import React, { useState } from 'react';
import api from '../api';
import { useNavigate } from 'react-router-dom';

function Register() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const register = async () => {
    try {
      await api.post('/auth/register', { username, password });
      navigate('/');
    } catch (error) {
      console.error(error);
      alert('Erro ao cadastrar');
    }
  };

  return (
    <div>
      <h1>Cadastro</h1>
      <input placeholder="Usuário" onChange={e => setUsername(e.target.value)} />
      <input type="password" placeholder="Senha" onChange={e => setPassword(e.target.value)} />
      <button onClick={register}>Cadastrar</button>
    </div>
  );
}

export default Register;
