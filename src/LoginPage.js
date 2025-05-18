import React, {useState} from 'react';
import { useNavigate } from 'react-router-dom';
import './LoginPage.css';

function LoginPage() {
    const[username, setUsername] = useState('');
    const[password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleLogic = async (e) => {
        e.preventDefault();

        const authAttempt = {username, password};

        const response = await fetch("http://localhost:8080/api/login", {
            method: 'POST',
            headers: { 'Content-type' : 'application/json', },
            body: JSON.stringify(authAttempt),
        });

        if (response.ok) {
            navigate('/');
        } else {
            alert('Попытка входа отклонена');
        }
    };

    return (
        <div className='login-password-container'>
            <h2>Welcome!</h2>
            <form onSubmit={handleLogic} className='new-user-authentithication'>

                <label>
                    <input 
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </label>

                <label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </label>

                <button type="submit">Login</button>
            </form>
        </div>
    );
}

export default LoginPage