using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace logikai_enprobalom
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {
            checkBox1.Checked = !checkBox1.Checked;
            checkBox2.Checked = !checkBox2.Checked;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            bool l = checkBox1.Checked && checkBox2.Checked;
            MessageBox.Show("a logiki eremeny " + l.ToString());

            //azt is csinalja hogy közben hozzáad dolgokat a listához
            listBox1.Items.Add(textBox1.Text);
        }
        private void button2_Click(object sender, EventArgs e)
        {
            listBox1.Items.RemoveAt(0);        }
    }
}
