import React, { useEffect, useState } from "react";
import { Bar, Pie } from "react-chartjs-2";
import axios from "axios";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
  ArcElement,
} from "chart.js";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
  ArcElement
);

const SubConcept_Completion = () => {
  const [chartData, setChartData] = useState(null);
  const programId = 1; // Example of parameter that you can pass to the API

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/userCohort/getStudentProgressByProgram",
          {
            params: {
              programId: 3, // Pass parameters here
            },
          }
        );

        const apiData = response.data;
        console.log(apiData);
        // Process data for bar chart and pie chart
        const names = apiData.map((item) => item[1]);
        const completedSubConcepts = apiData.map((item) => item[3]);
        const totalSubConcepts = apiData.map((item) => item[4]);
        const progressPercentage = apiData.map((item) => item[5]);

        setChartData({
          names,
          completedSubConcepts,
          totalSubConcepts,
          progressPercentage,
        });
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData(); // Call the async function
  }, [programId]); // Add programId as a dependency if it changes dynamically

  if (!chartData) {
    return <div>Loading...</div>;
  }

  // Bar chart data
  const barData = {
    labels: chartData.names,
    datasets: [
      {
        label: "Completed Sub-concepts",
        data: chartData.completedSubConcepts,
        backgroundColor: "rgba(75, 192, 192, 0.6)",
      },
      {
        label: "Total Sub-concepts",
        data: chartData.totalSubConcepts,
        backgroundColor: "rgba(153, 102, 255, 0.6)",
      },
    ],
  };

  // Pie chart data
  const pieData = {
    labels: chartData.names,
    datasets: [
      {
        label: "Progress Percentage",
        data: chartData.progressPercentage,
        backgroundColor: [
          "rgba(255, 99, 132, 0.6)",
          "rgba(54, 162, 235, 0.6)",
          "rgba(255, 206, 86, 0.6)",
        ],
      },
    ],
  };

  const barOptions = {
    responsive: true,
    maintainAspectRatio: false,
    plugins: {
      legend: {
        position: "top",
      },
      title: {
        display: true,
        text: "Student Progress (Completed vs Total Sub-concepts)",
      },
    },
  };

  const pieOptions = {
    responsive: true,
    maintainAspectRatio: false,
    plugins: {
      legend: {
        position: "top",
      },
      title: {
        display: true,
        text: "Progress Percentage by Student",
      },
    },
  };

  return (
    <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
      <h2>Student Scores Charts</h2>
      <div style={{ width: "600px", margin: "30px" }}>
        <Bar data={barData} options={barOptions} />
      </div>
      <div style={{ width: "400px", margin: "30px" }}>
        <Pie data={pieData} options={pieOptions} />
      </div>
    </div>
  );
};

export default SubConcept_Completion;
