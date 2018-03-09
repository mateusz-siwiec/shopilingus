const year = new Date().getFullYear();
document.querySelector('.date').innerHTML = year;

const HOST = 'http://localhost:8080';

function initFilters(filters) {
    const { shops, shopTypes } = filters;
    initShopFilters(shops);
    initShopTypesFilters(shopTypes);
}

const filterPromise = fetch(HOST + '/filters')
    .then(response => response.json())
    .then(filters => initFilters(filters))
    .catch(error => console.log(error));

function initShopFilters(shops) {
    const shopsFilterSelect = document.querySelector('.shop-select');
    shops.forEach(shop => {
        const shopElement = document.createElement('option');
        shopElement.setAttribute('value', shop.id);
        shopElement.innerHTML = shop.name;
        shopsFilterSelect.appendChild(shopElement);
    })
    console.log(shops);
}

function initShopTypesFilters(shopTypes) {
    const shopFiltersTypesSelect = document.querySelector('.shop-types');
    shopTypes.forEach(shopType => {
        const shopTypeLabel = document.createElement('label');
        const shopTypeInput = document.createElement('input');
        const shopTypeDiv = document.createElement('div');
        shopTypeInput.setAttribute('type', 'checkbox');
        shopTypeInput.setAttribute('value', shopType);
        shopTypeLabel.appendChild(shopTypeInput);
        shopTypeLabel.innerHTML += shopType;
        shopFiltersTypesSelect.appendChild(shopTypeLabel);
        shopFiltersTypesSelect.appendChild(shopTypeDiv);

    })
}

function getFilterParams() {
    const productNamePhrase = document.querySelector('.product-name').value;
    const minProductPrice = document.querySelector('.min-price').value;
    const maxProductPrice = document.querySelector('.max-price').value;
    const shopIds = document.querySelector('.shop-select').value;
    const shopTypesCheckBoxes = document.querySelectorAll('.shop-types label input');

    const shopTypes = Array.from(shopTypesCheckBoxes)
        .filter(shopType => shopType.checked)
        .map(shopType => shopType.value);

    return {
        productNamePhrase,
        minProductPrice,
        maxProductPrice,
        shopIds,
        shopTypes,
    };
}

function onLoadShop() {
    const filteringParams = getFilterParams();
    console.log(filteringParams);
    fetchFilteredShops(filteringParams).then(shops => showShops(shops));
}

const buttonData = document.querySelector('.button').addEventListener('click', onLoadShop);

const createQueryParamsString = object => Object.keys(object)
    .filter(key => object[key] !== undefined)
    .filter(key => String(object[key]) !== '')
    .map(key => `${key}=${object[key]}`)
    .join('&');

function fetchFilteredShops(filteringParams) {
    const queryString = createQueryParamsString(filteringParams);
    return fetch(HOST + '/shops?' + queryString)
        .then(response => response.json())
        .catch(error => console.log(error))

}

function createShopElement(shop) {

    const shopElement = document.createElement('div');
    const shopNameDiv = document.createElement('span');
    const shopTypeDiv = document.createElement('span');
    const shopLocationFloorDiv = document.createElement('span');
    const shopLocationBoxDiv = document.createElement('span');
    const shopDetailsElement = document.createElement('ul');
    shopTypeDiv.setAttribute('class', 'results');
    shopNameDiv.setAttribute('class', 'results');
    shopLocationFloorDiv.setAttribute('class', 'results');
    shopLocationBoxDiv.setAttribute('class', 'results');
    shopNameDiv.innerHTML = shop.name;
    shopTypeDiv.innerHTML = shop.shopTypes;
    shopLocationFloorDiv.innerHTML = shop.location.floor;
    shopLocationBoxDiv.innerHTML = shop.location.box;
    shopNameDiv.addEventListener('click', () => onShowShopDetails(shop , shopDetailsElement));
    shopElement.appendChild(shopNameDiv);
    shopElement.appendChild(shopTypeDiv);
    shopElement.appendChild(shopLocationFloorDiv);
    shopElement.appendChild(shopLocationBoxDiv);
    shopElement.appendChild(shopDetailsElement);
    return shopElement;
}

function showShops(shops) {
    const shopDivContainer = document.querySelector('.shop-information');
    shops
        .map(shop => createShopElement(shop))
        .forEach(shopDiv => shopDivContainer.appendChild(shopDiv))
}
function fetchProducts(shop) {
    return fetch(HOST + `/shops/${shop.id}/products`)
        .then(response => response.json())
        .catch(error => console.log(error))
}
function onShowShopDetails(shop , shopDetailsElement) {
    fetchProducts(shop).then(products => {
        products
        .map(createShopDetailsElement)
        .forEach(detailsElement => shopDetailsElement.appendChild(detailsElement));
    });
}
function createShopDetailsElement(product){
    const shopProductElement = document.createElement('li');
    const productName = document.createElement('span');
    const productQuantity = document.createElement('span');
    const productType = document.createElement('span');
    productName.setAttribute('class' , 'products-params');
    productQuantity.setAttribute('class' , 'products-params');
    productType.setAttribute('class' , 'products-params'); 
    productName.innerHTML = product.name;
    productQuantity.innerHTML = product.quantity;
    productType.innerHTML = product.type    
    shopProductElement.appendChild(productName);
    shopProductElement.appendChild(productType);
    shopProductElement.appendChild(productQuantity);
    return shopProductElement;
}

