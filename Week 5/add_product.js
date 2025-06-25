// javascript
// Found in the actual codebase - State mutation bug 
const addProduct = (product) => {
    setProducts(prevProducts => {
        const productInCart = prevProducts.find(p => p.id === product.id);
        if (productInCart) {
            // Return a new array with the updated product quantity (immutably)
            return prevProducts.map(p =>
                p.id === product.id
                    ? { ...p, quantity: p.quantity + 1 }
                    : p
            );
        } else {
            // Add a new product with quantity 1, without mutating the original product object
            return [...prevProducts, { ...product, quantity: 1 }];
        }
    });
};