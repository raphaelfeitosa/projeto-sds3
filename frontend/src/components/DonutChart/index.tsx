import Chart from "react-apexcharts";
import axios from 'axios';
import { Base_URL } from "utils/requests";
import { SaleSum } from "types/sale";
import { useEffect, useState } from "react";

type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {

    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`${Base_URL}/sales/amount-by-seller`)
            .then(response => {

                const data = response.data as SaleSum[];
                const myLabels = data.map(labels => labels.sellerName);
                const mySeries = data.map(series => series.sum);

                setChartData({ labels: myLabels, series: mySeries });

            });
    }, []);


    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;