import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../Service/api';

function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const login = async (e) => {
    e.preventDefault();
    try {
      const response = await api.post('/auth/login', { email, password });
      localStorage.setItem('token', response.data.token);
      setError('');
      navigate('/dashboard');
    } catch (error) {
      if (error.response) {
        setError(error.response.data.message || 'Login falhou');
      } else {
        setError('Erro na conexão com o servidor');
      }
      console.error(error);
    }
  };

  return (
    <form onSubmit={login}>
      <h1>Login</h1>
      <input
        placeholder="Email"
        value={email}
        onChange={e => setEmail(e.target.value)}
        required
      />
      <input
        type="password"
        placeholder="Senha"
        value={password}
        onChange={e => setPassword(e.target.value)}
        required
      />
      <button type="submit">Entrar</button>
      {error && <p style={{ color: 'red' }}>{error}</p>}
    </form>
  );
}

export default Login;
