import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import SupplierList from './components/SupplierList';
import CadastroProduto from './components/CadastroProduto';
import ListaProdutos from './components/ListaProdutos';
import Dashboard from './components/Dashboard';
import './App.css';
import logo from './assets/drop.jpg';

function App() {
  return (
    <BrowserRouter>
      <div className="app-container">
        <header className="app-header">
          <div className="logo">
            <img src={logo} alt="Logo" className="logo-img" />
            DropSpace
          </div>
          <nav className="nav-links">
            <Link to="/">Login</Link>
            <Link to="/register">Register</Link>
            <Link to="/dashboard">Dashboard</Link>
            <Link to="/produtos">Produtos</Link>
            <Link to="/fornecedores">Fornecedores</Link>
          </nav>
        </header>

        <main className="hero-section">
          <section className="hero-text">
            <h1>Connect suppliers and sellers in one place</h1>
            <p>
              Easily build your online store with our low-code tool, and get AI assistance for marketing and content creation.
            </p>
            <Link to="/register">
              <button className="get-started-btn">Get Started</button>
            </Link>
          </section>

          <section className="preview-box">
            <div className="stores">
              <h2>Stores</h2>
              <ul>
                <li></li>
                <li></li>
              </ul>
            </div>
            <div className="products">
              <h2>Products</h2>
              <ul>
                <li></li>
                <li></li>
                <li></li>
              </ul>
            </div>
          </section>
        </main>

        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/produtos" element={<ListaProdutos />} />
          <Route path="/produtos/novo" element={<CadastroProduto />} />
          <Route path="/fornecedores" element={<SupplierList />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
