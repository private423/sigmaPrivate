import React, { useState } from 'react';
import './App.css';

const App = () => {
  // Step 1: Declare state for search input and items list
  const [searchTerm, setSearchTerm] = useState('');
  const items = ['Apple', 'Banana', 'Cherry', 'Date', 'Grape', 'Orange', 'Strawberry'];

  // Step 2: Create onChange handler to update searchTerm state
  const handleSearch = (event) => {
    setSearchTerm(event.target.value);
  };

  // Step 3: Filter items based on the search term
  const filteredItems = items.filter((item) =>
    item.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="app">
      <h1>Search Filter</h1>
      <input
        type="text"
        placeholder="Search for an item..."
        value={searchTerm}
        onChange={handleSearch}
        className="search-input"
      />
      <ul>
        {filteredItems.length > 0 ? (
          filteredItems.map((item, index) => <li key={index}>{item}</li>)
        ) : (
          <li>No items found</li>
        )}
      </ul>
    </div>
  );
};

export default App;
