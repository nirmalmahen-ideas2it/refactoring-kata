// Utility for retrying async functions
async function retryAsync(fn, retries = 3, delay = 500) {
    let lastError;
    for (let i = 0; i < retries; i++) {
        try {
            return await fn();
        } catch (err) {
            lastError = err;
            if (i < retries - 1) await new Promise(res => setTimeout(res, delay));
        }
    }
    throw lastError;
}

export const fetchProducts = async () => {
    return retryAsync(async () => {
        try {
            const response = await fetch('/api/products');
            if (!response.ok) {
                // HTTP error
                throw new Error(`Failed to fetch products: ${response.status} ${response.statusText}`);
            }
            const data = await response.json();
            return data;
        } catch (err) {
            if (err.name === 'TypeError') {
                // Network error
                throw new Error('Network error: Unable to fetch products. Please check your connection.');
            }
            throw new Error(err.message || 'An unknown error occurred while fetching products.');
        }
    });
};

export const processPayment = async (paymentData) => {
    return retryAsync(async () => {
        try {
            const response = await fetch('/api/payment', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(paymentData)
            });
            if (!response.ok) {
                // HTTP error
                const errorBody = await response.text();
                throw new Error(`Payment failed: ${response.status} ${response.statusText} - ${errorBody}`);
            }
            const data = await response.json();
            // Optionally validate data here
            return data;
        } catch (err) {
            if (err.name === 'TypeError') {
                throw new Error('Network error: Unable to process payment. Please check your connection.');
            }
            throw new Error(err.message || 'An unknown error occurred while processing payment.');
        }
    });
};
