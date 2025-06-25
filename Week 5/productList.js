import React, { useMemo } from "react";

const ProductList = ({ products, filters }) => {
    // Performance monitoring
    console.time("Product filtering");

    const filteredProducts = useMemo(() => {
        // Early return if no filters
        if (!filters || (!filters.sizes?.length && !filters.maxPrice)) {
            return products;
        }
        return products.filter(product => {
            // Check price first for early exit
            if (filters.maxPrice && product.price > filters.maxPrice) return false;
            // If sizes filter is empty, skip size check
            if (filters.sizes && filters.sizes.length > 0) {
                return filters.sizes.every(size =>
                    product.availableSizes.includes(size)
                );
            }
            return true;
        });
    }, [products, filters]);

    console.timeEnd("Product filtering");

    return (
        <div>
            {filteredProducts.map(product => (
                <ProductItem key={product.id} product={product} />
            ))}
        </div>
    );
};
