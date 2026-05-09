import {BrowserRouter, Routes, Route} from "react-router"
import { createRoot } from 'react-dom/client'
import './index.css'
import Login from "./pages/Login.jsx"
import Chat from "./pages/Chat.jsx";

createRoot(document.getElementById('root')).render(
  <BrowserRouter>
      <Routes>
          <Route path="/" element={<Login/>}/>
          <Route path="/Chat" element={<Chat/>}/>
      </Routes>
  </BrowserRouter>
)
