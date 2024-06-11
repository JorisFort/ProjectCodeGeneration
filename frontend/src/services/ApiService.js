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

        const response = await fetch(url, options);
        if (response.ok) {
            return await response.json();
        } else {
            const error = new Error(await response.text());
            error.isCustomError = true;
            throw error;
        }
    } catch (error) {
        if (!error.isCustomError) {
            console.error(error.message);
            error.message = "Something went wrong. Please try again later.";
        }

        throw error;
    }
};