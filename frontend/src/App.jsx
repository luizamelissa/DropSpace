import { BrowserRouter, Routes, Route, Link } from 'react-router-dom'
import Login from './components/Login'
import Register from './components/Register'
import Dashboard from './components/Dashboard'
import './App.css'
import logo from './assets/drop.jpg'

function App() {
  return (
    <div className="app-container">
      <header className="app-header">
        <div className="logo">
          <img src={logo} alt="Logo" className="logo-img" />
          DropSpace
        </div>
        <nav className="nav-links">
          <Link to="/">Login</Link>
          <Link to="/register">Register</Link>
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
      </Routes>
    </div>
  )
}

export default App
