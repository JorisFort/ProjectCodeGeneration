export const apiCall = async (url, method, body = null) => {
    try {
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

        const response = await fetch(url, options);
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