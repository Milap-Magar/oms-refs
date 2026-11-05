# Step by Step planning for the project of OMS
- Basically OMS is acronym for ***Order management system***
- It is basically the inventory and the handling of orders and products.
- It can also track all the assets present in the storage.

### Phase 1 : BASIC AUTHENTICATION
- Create the authentication endpoints and handlers accordingly.
- Generate `/login` && `/register` endpoints for the OMS.
- Add a layer of protection like `isAuth()` before any of the order or inventory related operations.

#### Endppoints:
```bash
    POST /api/auth/register - Register a new user/admin in the system.
    
    POST /api/auth/login - Authenticate user credentials and return a session token or JWT.
    
    POST /api/auth/logout - Invalidate the user session or token.
    
    GET /api/auth/me - Retrieve the currently authenticated user's profile details.
```
### Phase 2 : Create Product Endpoints before Inventory [[CURRENTLY HERE]]
- So, basically creating `/product` endpoints before any other because in inventory products are the major things needed for inventory management.
- Create variables as well like kind of product details but with size, weight, and other essentials for a general inventory.

- ENDPOINTS: 
```bash
    POST /api/products - Create a new product with details (name, description, SKU, size, weight, category, price).
    
    GET /api/products - Retrieve a paginated list of all products in the catalog.
    
    GET /api/products/:id - Retrieve details of a specific product by its ID.
    
    PUT /api/products/:id - Update an existing products details or specifications.
    
    DELETE /api/products/:id - Remove a product from the catalog. 
```