export const apiCall = async (url, method, body = null) => {
    try {
        const hostname = window.location.hostname;
        const baseUrl = hostname === 'localhost' ? 'http://localhost:8080' : 'https://projectcodegeneration.onrender.com';
        const fullUrl = `${baseUrl}${url}`;

        const options = {
            method,
            headers: {
                "Content-Type": "application/json",
            },
        };

        if (body) {
            options.body = JSON.stringify(body);
        }

        const jwtToken = localStorage.getItem('jwtToken');
        if (jwtToken) {
            options.headers['Authorization'] = `Bearer ${jwtToken}`;
        }

        const response = await fetch(fullUrl, options);
        if (response.ok) {
            return await response.json();
        } else {
            throw new Error(await response.text());
        }
    } catch (error) {
        console.error('API call failed:', error);
        throw error;
    }
};