import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const FirstPage = ({ onStudentFetch }) => {
  const [formData, setFormData] = useState({
    registrationNumber: "",
    emailId: "",
    dateOfBirth: "",
    captcha: "",
  });

  const [error, setError] = useState("");
  const [success, setSuccess] = useState("");

  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setSuccess("");

    // Basic frontend validation
    if (!formData.captcha || formData.captcha !== "12345") {
      setError("Invalid CAPTCHA. Try again.");
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:8080/api/students/validate`,
        {
          params: {
            registrationNumber: formData.registrationNumber,
            emailId: formData.emailId,
            dateOfBirth: formData.dateOfBirth,
          },
        }
      );
      const studentData = response.data;

      // Pass the fetched data to the parent
      onStudentFetch(studentData);

      setSuccess("Student data fetched successfully!");
      navigate("/second-page", { state: { student: studentData } }); // Navigate to the second page
    } catch (err) {
      setError("Student not found or an error occurred.");
    }
  };

  return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center">
      <div className="bg-white p-6 rounded-lg shadow-lg w-full max-w-md">
        <h1 className="text-2xl font-bold text-gray-800 mb-4 text-center">
          LOR Request Form
        </h1>
        <form onSubmit={handleSubmit}>
          <div className="mb-4">
            <label className="block text-gray-700">Registration Number</label>
            <input
              type="text"
              name="registrationNumber"
              value={formData.registrationNumber}
              onChange={handleChange}
              className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
              placeholder="Enter registration number"
              required
            />
          </div>

          <div className="mb-4">
            <label className="block text-gray-700">Email</label>
            <input
              type="email"
              name="emailId"
              value={formData.emailId}
              onChange={handleChange}
              className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
              placeholder="Enter email address"
              required
            />
          </div>

          <div className="mb-4">
            <label className="block text-gray-700">Date of Birth</label>
            <input
              type="date"
              name="dateOfBirth"
              value={formData.dateOfBirth}
              onChange={handleChange}
              className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
              required
            />
          </div>

          <div className="mb-4">
            <label className="block text-gray-700">CAPTCHA</label>
            <input
              type="text"
              name="captcha"
              value={formData.captcha}
              onChange={handleChange}
              className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
              placeholder="Enter CAPTCHA (12345)"
              required
            />
          </div>

          {error && <p className="text-red-500 text-sm mb-4">{error}</p>}
          {success && <p className="text-green-500 text-sm mb-4">{success}</p>}

          <button
            type="submit"
            className="w-full bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded-lg transition-all"
          >
            Submit
          </button>
        </form>
      </div>
    </div>
  );
};

export default FirstPage;
