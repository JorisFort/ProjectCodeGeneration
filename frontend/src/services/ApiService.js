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

        const contentType = response.headers.get("Content-Type");

        if (response.ok) {
            return await response.json();
        } else {
            throw new Error(await response.text());
        }
    } catch (error) {
        throw new Error(error.message || "An error occurred");
    }
};
