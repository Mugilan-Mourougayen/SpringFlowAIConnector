
import Login from './components/Login';
import Register from './components/Register';
import BlogEditor from './components/BlogEditor';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Register/>
        <hr/>
      <Login/>
      <hr/>
      <BlogEditor/>
      </header>
    </div>
  );
}

export default App;
