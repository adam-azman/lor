import React, { useState } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import FirstPage from "./pages/FirstPage";
import SecondPage from "./pages/SecondPage";

function App() {
  const [student, setStudent] = useState(null); // State to hold student data.

  const handleStudentFetch = (data) => {
    setStudent(data); // Store fetched student data in state.
    console.log("Student fetched:", data); // For debugging.
  };

  return (
    <Router>
      <Routes>
        {/* Pass handleStudentFetch as a prop to FirstPage */}
        <Route path="/" element={<FirstPage onStudentFetch={handleStudentFetch} />} />
        {/* Pass student data as a prop to SecondPage */}
        <Route path="/second-page" element={<SecondPage student={student} />} />
      </Routes>
    </Router>
  );
}

export default App;
