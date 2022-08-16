import Navbar from "./components/Navbar";
import ProtectedRoute from "./components/ProtectedRoute";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import {
  // BrowserRouter as Router,
  Route,
  Routes,
  // Link,
  Navigate,
} from "react-router-dom";

function App() {
  let { user } = false

  var usernameStore = sessionStorage.getItem("username");
  if (usernameStore != null) 
      user = true
  
  return (
    <>
      <Navbar />
      <Routes>
        <Route exact path='/' element={user ? <Home /> : <Navigate to="/login" />}></Route> 
        <Route path='/login' element={!user ? <Login /> : <Navigate to="/"/>}></Route>
        <Route path='/signup' element={!user ? <Signup /> : <Navigate to="/"/>}></Route>
      </Routes> 
    </>
  );
}

export default App;
