import React, { useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import axios from "axios";

const SecondPage = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const { student } = location.state || {}; // Retrieved student data from the first page

  // Initialize editable fields with existing data or defaults
  const [formData, setFormData] = useState({
    email_id: student?.email_id || "",
    mobile_number: student?.mobile_number || "",
    date_of_birth: student?.date_of_birth || "",
    linkedin_id: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/api/students/submit", {
        registration_number: student.registration_number,
        student_name: student.student_name,
        ...formData,
      });
      alert("Data submitted successfully");
      navigate("/"); // Redirect to the home or confirmation page
    } catch (error) {
      console.error("Error submitting data:", error);
      alert("Failed to submit data. Please try again.");
    }
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <form
        className="bg-white p-6 rounded-lg shadow-md space-y-4 w-full max-w-lg"
        onSubmit={handleSubmit}
      >
        <h2 className="text-2xl font-bold text-center mb-4">Student Details</h2>

        <div>
          <label className="block font-medium">Registration Number</label>
          <input
            type="text"
            value={student?.registration_number || ""}
            readOnly
            className="w-full p-2 border rounded bg-gray-100 cursor-not-allowed"
          />
        </div>

        <div>
          <label className="block font-medium">Name</label>
          <input
            type="text"
            value={student?.student_name || ""}
            readOnly
            className="w-full p-2 border rounded bg-gray-100 cursor-not-allowed"
          />
        </div>

        <div>
          <label className="block font-medium">Email</label>
          <input
            type="email"
            name="email_id"
            value={formData.email_id}
            onChange={handleChange}
            className="w-full p-2 border rounded"
          />
        </div>

        <div>
          <label className="block font-medium">Mobile Number</label>
          <input
            type="text"
            name="mobile_number"
            value={formData.mobile_number}
            onChange={handleChange}
            className="w-full p-2 border rounded"
          />
        </div>

        <div>
          <label className="block font-medium">Date of Birth</label>
          <input
            type="date"
            name="date_of_birth"
            value={formData.date_of_birth}
            onChange={handleChange}
            className="w-full p-2 border rounded"
          />
        </div>

        <div>
          <label className="block font-medium">LinkedIn ID</label>
          <input
            type="text"
            name="linkedin_id"
            value={formData.linkedin_id}
            onChange={handleChange}
            className="w-full p-2 border rounded"
            placeholder="Enter LinkedIn profile URL"
          />
        </div>

        <button
          type="submit"
          className="w-full bg-blue-500 text-white p-2 rounded hover:bg-blue-600"
        >
          Submit
        </button>
      </form>
    </div>
  );
};

export default SecondPage;
